#!/bin/bash
# filepath: /home/luis/Escritorio/commitss/scripts/masScripts/monitor_sistema.sh

# Configuración de umbrales
CPU_THRESHOLD=80
MEMORY_THRESHOLD=80
EMAIL="tu_correo@example.com"
OUTPUT_FILE="/ruta/al/informe_sistema.txt"

# Función para obtener el uso de CPU
get_cpu_usage() {
    top -bn1 | grep "Cpu(s)" | \
    sed "s/.*, *\([0-9.]*\)%* id.*/\1/" | \
    awk '{print 100 - $1}'
}

# Función para obtener el uso de memoria
get_memory_usage() {
    free | grep Mem | awk '{print $3/$2 * 100.0}'
}

# Función para enviar alertas por correo electrónico
send_alert() {
    local subject=$1
    local message=$2
    echo "$message" | mail -s "$subject" "$EMAIL"
}

# Función para generar el informe del sistema
generate_report() {
    echo "Informe del sistema - $(date)" > "$OUTPUT_FILE"
    echo "---------------------------------" >> "$OUTPUT_FILE"
    echo "Uso de CPU: $(get_cpu_usage)%" >> "$OUTPUT_FILE"
    echo "Uso de memoria: $(get_memory_usage)%" >> "$OUTPUT_FILE"
    echo "Espacio en disco:" >> "$OUTPUT_FILE"
    df -h >> "$OUTPUT_FILE"
    echo "Procesos principales:" >> "$OUTPUT_FILE"
    ps aux --sort=-%mem | head -n 10 >> "$OUTPUT_FILE"
}

# Monitoreo del sistema
while true; do
    CPU_USAGE=$(get_cpu_usage)
    MEMORY_USAGE=$(get_memory_usage)

    if (( $(echo "$CPU_USAGE > $CPU_THRESHOLD" | bc -l) )); then
        send_alert "Alerta de CPU alta" "El uso de CPU ha superado el umbral de $CPU_THRESHOLD%. Uso actual: $CPU_USAGE%"
    fi

    if (( $(echo "$MEMORY_USAGE > $MEMORY_THRESHOLD" | bc -l) )); then
        send_alert "Alerta de memoria alta" "El uso de memoria ha superado el umbral de $MEMORY_THRESHOLD%. Uso actual: $MEMORY_USAGE%"
    fi

    generate_report
    sleep 60
done


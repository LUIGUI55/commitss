# CRUD SQL Server Application

This project is a CRUD (Create, Read, Update, Delete) application built using TypeScript and Express, designed to interact with a SQL Server database.

## Project Structure

```
crud-sqlserver-app
├── src
│   ├── controllers
│   │   └── index.ts
│   ├── models
│   │   └── index.ts
│   ├── routes
│   │   └── index.ts
│   ├── services
│   │   └── index.ts
│   └── app.ts
├── config
│   └── database.ts
├── package.json
├── tsconfig.json
└── README.md
```

## Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd crud-sqlserver-app
   ```

3. Install the dependencies:
   ```
   npm install
   ```

## Configuration

Before running the application, ensure that you configure the database connection settings in `config/database.ts`. Update the connection string and any necessary options to connect to your SQL Server database.

## Usage

To start the application, run the following command:
```
npm start
```

The application will be running on `http://localhost:3000` (or the port specified in your configuration).

## API Endpoints

The application exposes the following API endpoints:

- `POST /resource` - Create a new resource
- `GET /resource` - Retrieve all resources
- `GET /resource/:id` - Retrieve a resource by ID
- `PUT /resource/:id` - Update a resource by ID
- `DELETE /resource/:id` - Delete a resource by ID

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
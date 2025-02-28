import { Router } from 'express';
import IndexController from '../controllers/index';

const router = Router();
const indexController = new IndexController();

export function setRoutes(app) {
    app.use('/api/resource', router);

    router.post('/', indexController.create);
    router.get('/', indexController.read);
    router.put('/:id', indexController.update);
    router.delete('/:id', indexController.delete);
}
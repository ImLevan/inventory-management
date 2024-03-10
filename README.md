# 📦 Inventory management

<p align="center"><img width=30% height=45% src="https://github.com/ImLevan/inventory-management/assets/91690079/d7da0d28-05cd-488c-a599-299358d4ecc4"></p>


> © Desarrollado por Valentin Chianese
## Descripción

Inventory Management es una aplicación de escritorio que proporciona un sistema completo para gestionar inventarios y ventas. El proyecto está diseñado para facilitar las tareas de gestión relacionadas con usuarios, categorías, productos, proveedores, existencias y ventas en un entorno de negocios.

Las características principales del proyecto son:

- **Gestión de Usuarios:** Registro y gestión de usuarios al sistema.

- **Gestión de Categorías:** Categorización de productos para una organización más eficiente.

- **Gestión de Productos:** Registro, edición y eliminación de productos, así como la asignación de categorías.

- **Gestión de Proveedores:** Registro y seguimiento de proveedores para garantizar un suministro adecuado.

- **Gestión de Existencias:** Control de las existencias de productos, vinculando un producto con un proveedor, incluyendo las existencias vendidas y actuales.

- **Gestión de Ventas:** Registro y seguimiento de las ventas, con métricas y análisis relacionados.

- **Dashboard:** Información visual sobre ganancias, cantidad de productos, existencias, proveedores, y más.

El proyecto está desarrollado en Java utilizando el patrón de arquitectura MVC y tecnologías como Java, Java Swing, JPA y PostgreSQL.

## Diseño

El modelo de entidad-relación del proyecto se muestra en el siguiente diagrama, ilustrando cómo se relacionan las entidades principales y sus atributos:

![diagram](https://github.com/ImLevan/inventory-management/assets/91690079/0171a972-e356-44c1-baf8-16f21f4b622b)


## Implementación

El código sigue el patrón MVC, utilizando JPA para el mapeo entre clases y tablas de la base de datos. A continuación, se presentan capturas de pantalla de la interfaz de usuario:

### Login

- Pantalla de inicio de sesión para acceder al sistema.

![Screenshot Login](https://github.com/ImLevan/inventory-management/assets/91690079/d7da0d28-05cd-488c-a599-299358d4ecc4)

### Dashboard

- Dashboard que presenta métricas actualizadas mensualmente sobre ingresos y estadísticas clave.

![dashboard](https://github.com/ImLevan/inventory-management/assets/91690079/f8b02bd6-5fae-4187-9d97-e90cb4670828)


### Gestión de Usuarios, Categorías y Productos

- Pantallas de gestión de usuarios, categorías y productos con opciones de creación, edición y eliminación.

![usuarios](https://github.com/ImLevan/inventory-management/assets/91690079/fbab4a46-8e67-4086-a305-0aca4112790d)
![categorias](https://github.com/ImLevan/inventory-management/assets/91690079/f6ea527e-0733-4a15-86bf-f29ef65f1fdb)
![productos](https://github.com/ImLevan/inventory-management/assets/91690079/3417fcf6-6f1a-4e8d-8b6d-4e12ed3b1f41)




### Gestión de Existencias y Proveedores

- Pantallas de gestión de existencias y proveedores.
![existencias](https://github.com/ImLevan/inventory-management/assets/91690079/8ad9f197-e8d0-4851-9443-61b8b2d3f8ac)
![agregarExistencia](https://github.com/ImLevan/inventory-management/assets/91690079/3d2416d1-b68f-45a8-a853-0f17640a5cf3)
![proveedores](https://github.com/ImLevan/inventory-management/assets/91690079/5c445354-ffb1-4b90-9bfe-dcc5a2ae9e74)


### Gestión de Ventas 

- Pantallas de gestión de ventas con detalles sobre los clientes y sus compras.
![ventas](https://github.com/ImLevan/inventory-management/assets/91690079/0919c421-585a-4e9a-a5ef-f1892361710b)
![verVenta](https://github.com/ImLevan/inventory-management/assets/91690079/6ef74ef8-8c22-49aa-a050-4e059b8c0704)
![agregarVenta](https://github.com/ImLevan/inventory-management/assets/91690079/11c4690c-3ed0-4b84-9fcf-54220be4db3a)


## Documentación

La documentación técnica completa del proyecto se encuentra disponible [aquí](https://docs.google.com/document/d/1VV7-y1ycgLpaTwBV3YA210YF9Iwq_C9MfiGH5S7s7c4/edit?usp=sharing).

## Contribuciones

Se aceptan contribuciones externas y comentarios para mejorar el sistema en futuras versiones.

## Créditos
Desarrollado por [Valentin Chianese](https://github.com/ImLevan).

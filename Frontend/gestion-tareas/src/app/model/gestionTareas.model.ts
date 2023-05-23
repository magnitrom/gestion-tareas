export class Usuario {
    idGesTareasRegistrosUsuarios: number = 0;
    usuario: string = "";
    nombre: string = "";
    correoElectronico: string = "";
    contrasenia: string = "";
    fechaCreacion: string = "";
    usuarioCreacion: string = "";
    fechaModificacion: string = "";
    usuarioModificacion: string = "";
}

export class ResponseObject {
    state: string = "";
    message: string = "";
    data: any = ""
}

export class Tarea{
    idgesTareas: number = 0;
    idgesTareasRegistrosUsuarios: number = 0;
    idgesTareasEstados: number = 0;
    titulo: string = "";
    descripcion: string = "";
    fechaCreacion: string = "";
    usuarioCreacion: string = "";
    fechaModificacion: string = "";
    usuarioModificacion: string = "";
}

export class Estados{
    idgesTareasEstados: number = 0;
    nombreEstado: string = '';
    descripcionEstado: string = '';
    fechaCreacion: string = '';
    usuarioCreacion: string = '';
    fechaModificacion: string = '';
    usuarioModificacion: string = '';
}
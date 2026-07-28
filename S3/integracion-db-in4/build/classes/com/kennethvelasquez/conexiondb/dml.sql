use gestor_usuarios_in4am;

call sp_create_usuario("Kenneth", "Velasquez", "kennethvelasquez","123456789", "Administrador");
call sp_create_usuario("Bryan", "Rodriguez", "bryanrodriguez","987654321","Usuario");

call sp_read_usuarios();
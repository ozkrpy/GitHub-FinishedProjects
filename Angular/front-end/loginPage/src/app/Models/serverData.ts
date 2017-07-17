module.exports = {
    server: {
        host: 'localhost',
        port: '9092',
        typeGET: 'GET',
        typePOST: 'POST',
        methods: {
            helloWorld: '/helloworld',
            usuarios: '/users',
            usuariosPorUsuario: '/usersByUsuario/{usuario}',
            pacientes: '/pacientes',
            pacientePorId: '/pacientePorId/{busqueda}',
            dietas: '/dietas'
        }
    }
};
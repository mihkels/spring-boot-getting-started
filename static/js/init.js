require.config({
    baseUrl: 'bower_components',
    paths: {
        jQuery: 'jquery/dist/jquery.min',
        bootstrap: 'bootstrap/dist/js/bootstrap.min'
    },
    shim: {
        jQuery: {
            exports: 'JQuery'
        },
        bootstrap: {
            deps: ['jQuery'],
            exports: 'bootstrap'
        }
    },
    waitSeconds: 20
});

require(
    ['jQuery', 'bootstrap'],
    function () {
        console.log('hello world')
    }
);
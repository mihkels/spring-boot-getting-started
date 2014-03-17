var vendor = 'vendor/';
require.config({
    baseUrl: 'js',
    paths: {
        jQuery: vendor + 'jquery/jquery',
        bootstrap: vendor + 'bootstrap/dist/js/bootstrap',
        Handlebars: vendor + 'handlebars/handlebars',
        Ember: vendor + "ember/ember"
    },
    shim: {
        'jQuery': {
            exports: 'jQuery'
        },
        'bootstrap': {
            deps: ['jQuery'],
            exports: 'bootstrap'
        },
        'Handlebars': {
            exports: 'Handlebars'
        },
        'Ember': {
            deps: ['Handlebars'],
            exports: 'Ember'
        }
    },
    waitSeconds: 20
});

require(
    ['jQuery', 'bootstrap', 'Ember', 'main'],
    function ($, bootstrap, Ember, AppMain) {
        AppMain();
    }
);
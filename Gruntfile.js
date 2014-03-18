module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: ';',
                stripBanners: true
            },
            dist: {
                src: ['static/vendor/jquery.js', 'static/vendor/handlebars.js', 'static/vendor/*.js'],
                dest: 'static/js/combined.js'
            }
        },
        clean: ['static/vendor'],
        bowercopy: {
            options: {
                clean: true
            },
            libs: {
                options: {
                    destPrefix: 'static/vendor/'
                },
                files: {
                    'jquery.js': 'jquery/jquery.js',
                    'handlebars.js': 'handlebars/handlebars.js',
                    'ember.js': 'ember/ember.js',
                    'bootstrap.js': 'bootstrap/dist/js/bootstrap.js'
                }
            },
            folders: {
                files: {
                    'static/fonts': 'bootstrap/dist/fonts'
                }
            },
            glob: {
                files: {
                    'static/css': 'bootstrap/dist/css/*[^min].css'
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-bowercopy');

    grunt.registerTask('default', ['bowercopy', 'concat', 'clean']);
};
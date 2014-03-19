module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: ';',
                stripBanners: true
            },
            dist: {
                src: ['vendor/jquery.js', 'vendor/handlebars.js', 'vendor/*.js'],
                dest: 'js/combined.js'
            }
        },
        clean: ['vendor'],
        copy: {
            main: {
                files: [
                    {expand: true, src: ['js/*', 'css/*', 'fonts/*', '*.html'], dest: '../src/main/webapp/'}
                ]
            }
        },
        bowercopy: {
            options: {
                clean: true
            },
            libs: {
                options: {
                    destPrefix: 'vendor/'
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
                    'fonts': 'bootstrap/dist/fonts'
                }
            },
            glob: {
                files: {
                    'css': 'bootstrap/dist/css/*[^min].css'
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-bowercopy');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask('default', ['bowercopy', 'concat', 'clean', 'copy']);
};
window.App = Ember.Application.create({
    VERSION: '0.1.0'
});

App.Router.map(function () {
    this.resource('demo',  {path: '/'});
});

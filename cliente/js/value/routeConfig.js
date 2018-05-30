// Definindo Rotas
angular.module('listaAgenda').config(function($routeProvider, $locationProvider){
    $routeProvider.when('/agendaEventos', {
      templateUrl: 'listar-agenda.html',
      controller: 'listaAgendaCtrl',
      controllerAs: 'vm' //Alias da controller   
    })
    .when('/adicionarEvento', {
      templateUrl: 'adicionar-agenda.html',
      controller: 'adicionarEventoCtrl',
      controllerAs: 'c' //Alias da controller
    });
  
    $locationProvider.hashPrefix('');
  });
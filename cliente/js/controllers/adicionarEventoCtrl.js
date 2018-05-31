angular.module('listaAgenda').controller('adicionarEventoCtrl', function(agendaAPI, $scope, $location, toaster) {
  var c = this;
  c.adicionarEvento = function(agenda) {
    agendaAPI.salvarAgenda(agenda).then(function (data) {
      delete $scope.agenda;
      $location.path('/');
      toaster.pop('info', "Sucesso", 'O Evento foi cadastrado com sucesso');
    }).catch(function(err){
      toaster.pop('warning', "Aviso", err.data.message);
    });
  };
});



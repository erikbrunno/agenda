angular.module('listaAgenda').factory('alert', function($uibModal) {
  function show(action, event) {
    return $uibModal.open({
      templateUrl: 'detalhar-agenda.html',
      controller: function() {
        var vm = this;
        vm.action = action;
        vm.event = event;
      },
      controllerAs: 'vm'
    });
  }
  return {
    show: show
  };
});
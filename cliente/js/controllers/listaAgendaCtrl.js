angular.module('listaAgenda').controller('listaAgendaCtrl', function(agendaAPI, moment, alert, calendarConfig, toaster) {
    var vm = this;
    //Seta a inicialização padrao do calendario
    vm.calendarView = 'month';

    //Seta a data atual na inicializacao do calendario
    vm.viewDate = new Date();
    
    var actions = [{
      label: '<i class=\'glyphicon glyphicon-remove\'></i>',
      onClick: function(args) {
        agendaAPI.removerAgenda(args.calendarEvent).then(function (data) {
          carregarAgenda();
          toaster.pop('info', "Sucesso", 'O Evento foi removido com sucesso');
        });        
      }
    }];

    var carregarAgenda = function () {
      vm.events = [];
      agendaAPI.getAgenda().then(function(data) {
        angular.forEach(data.data, function(value) {
          var dataInicio = moment(value.dataInicio[1] + '/' + value.dataInicio[2] + '/' + value.dataInicio[0])
            .add(value.horaInicio[3], 'hours').add(value.horaInicio[3], 'minutes').toDate();
          
          var dataFim = moment().add(1, 'year').toDate();
          if(value.dataFim != null) {
            dataFim = moment(value.dataFim[1] + '/' + value.dataFim[2] + '/' + value.dataFim[0])
              .add(8, 'hours').toDate();
          }
          vm.events.push({
            id: value.id,
            title: value.nome,
            color: calendarConfig.colorTypes.warning,
            startsAt: dataInicio,
            endsAt: dataFim,
            draggable: true,
            resizable: true,
            actions: actions
          });
        });
      }).catch(function(err){
        if(err.data.status == '404') {
          toaster.pop('error', "Aviso", 'Erro de comunicação com o servidor.');
        }
      });
    }
    vm.cellIsOpen = true;

    vm.eventClicked = function(event) {
      console.log('Entrou aqui');
      alert.show('Clicked', event);
    };

    vm.eventEdited = function(event) {
      console.log('Entrou aqui2');
      alert.show('Edited', event);
    };

    vm.eventTimesChanged = function(event) {
      console.log('Entrou aqui4');
      alert.show('Dropped or resized', event);
    };

    vm.timespanClicked = function(date, cell) {
      if (vm.calendarView === 'month') {
        if ((vm.cellIsOpen && moment(date).startOf('day').isSame(moment(vm.viewDate).startOf('day'))) || cell.events.length === 0 || !cell.inMonth) {
          vm.cellIsOpen = false;
        } else {
          vm.cellIsOpen = true;
          vm.viewDate = date;
        }
      } else if (vm.calendarView === 'year') {
        if ((vm.cellIsOpen && moment(date).startOf('month').isSame(moment(vm.viewDate).startOf('month'))) || cell.events.length === 0) {
          vm.cellIsOpen = false;
        } else {
          vm.cellIsOpen = true;
          vm.viewDate = date;
        }
      }
    };

    vm.toggle = function($event, field, event) {
      console.log('parece ser lixo');
      $event.preventDefault();
      $event.stopPropagation();
      event[field] = !event[field];
    };

    //Carrega todos os eventos
    carregarAgenda();
  });
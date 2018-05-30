angular.module("listaAgenda").factory("agendaAPI", function($http, config) {
    var _getAgenda = function() {
        return $http.get(config.baseUrl + '/agenda/consulta');
    };

    var _salvarAgenda = function(agenda) {
        return $http.post(config.baseUrl + '/agenda/adicionar', agenda);
    };

    var _removerAgenda = function(agenda) {
        return $http.post(config.baseUrl + '/agenda/remover', agenda);
    };

    return {
        getAgenda: _getAgenda,
        salvarAgenda: _salvarAgenda,
        removerAgenda: _removerAgenda
    };
});
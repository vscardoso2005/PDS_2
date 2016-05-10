var musicaModule = angular.module('musicaModule', []);

musicaModule.controller("musicaControl", function($scope, $http) {

	urlMusica = 'http://localhost:8080/ProjetoDesenvolvimentoII/rs/musica';

	urlAlbum = 'http://localhost:8080/ProjetoDesenvolvimentoII/rs/album';

	$scope.pesquisarMusica = function() {
		$http.get(urlMusica).success(function(musicasRetorno) {
			$scope.musicas = musicasRetorno;
		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.pesquisarAlbum = function() {
		$http.get(urlAlbum).success(function(albunsRetorno) {
			$scope.albuns = albunsRetorno;
		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.salvar = function() {
		if ($scope.musica.codMusica == '') {
			$http.post(urlMusica, $scope.musica).success(function(musica) {
				$scope.musicas.push($scope.musica);
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		} else {
			$http.put(urlMusica, $scope.musica).success(function(musica) {
				$scope.pesquisarMusica();
				$scope.novo();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}

	$scope.excluir = function() {
		if ($scope.musica.codMusica == '') {
			alert('Campo Vazio!!!');
		}else {
			urlExcluir = urlMusica + "/" + $scope.musica.codMusica;
			$http.delete(urlExcluir).success(function() {
				$scope.pesquisarMusica();
				$scope.novo();
			})
		}
		$scope.musicas.splice($scope.musicas.indexOf($scope.musica), 1);
		$scope.novo();
	}

	$scope.novo = function() {
		$scope.musica = "";
	}

	$scope.selecionaMusica = function(musica) {
		$scope.musica = musica;
	}
	
	$scope.selecionaAlbum = function(album) {
		alert(selecionaAlbum);
		$scope.musica.album = album;
	}

	$scope.pesquisarMusica();
	$scope.pesquisarAlbum();
});
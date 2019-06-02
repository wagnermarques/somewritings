package eteczl.edu.br.firebaseauth

import kotlinx.coroutines.Deferred

interface IAuth<ResultType> {

    fun getCurrentUser() : Deferred<ResultType>;
    fun registraUsuario() : Deferred<ResultType>;

}
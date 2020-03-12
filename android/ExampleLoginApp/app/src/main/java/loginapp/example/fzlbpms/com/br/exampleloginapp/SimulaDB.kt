package loginapp.example.fzlbpms.com.br.exampleloginapp

class AppStaticServices{

    companion object {
        public fun login(username:String, password:String) : Boolean {
            var ret: Boolean = false
            if(username is String && password is String){
                if (username.equals("admin") && password.equals("admin123")){
                    ret = true;
                }
            }
            return ret;
        }

        public fun loginDB(username:String, password:String, ) : Boolean {
            var ret: Boolean = false
            if(username is String && password is String){
                if (username.equals("admin") && password.equals("admin123")){
                    ret = true;
                }
            }
            return ret;
        }
    }
}
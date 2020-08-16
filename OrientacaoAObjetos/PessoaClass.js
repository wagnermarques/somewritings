class Pessoa {

    //navegadores antigos precisam de polifyl pra funcionar isso...
    static #DNA = "CromossomoHDeHumano";
    #segredoPessoal = "";   
    url = null;
    
    constructor(nome, strSegredoDeNascensa){
        this.nome = nome;
        this.#segredoPessoal = strSegredoDeNascensa;
    }
    
    falar(str){
        console.log(str);
    }
    
    get lang(){
        return this._lang;
    }
    
    set lang(value){
        this._lang = value;
    }    
}

let pessoaAda = new Pessoa("Ada Lovelace","O Babbage e fraco na parte algoritmos rsrsr, eu tenho que fazer tudo grr..");
let pessoaJG = new Pessoa("James Gosling","");
let pessoaYM = new Pessoa("Yukihiro Matsumoto");

pessoaAda.lang = "Ada";
pessoaJG.lang = "Java";
pessoaYM.lang = "Ruby";

pessoaAda.url = "https://pt.wikipedia.org/wiki/Ada_Lovelace";
pessoaJG.url = "https://pt.wikipedia.org/wiki/James_Gosling";
pessoaYM.url = "https://pt.wikipedia.org/wiki/Yukihiro_Matsumoto";


pessoaAda.falar("Ada falando: O primeiro programador foi uma programadora. Criei a linguagem "+pessoaAda.lang);
console.log(pessoaAda.url);
console.log("Segredo de nascenca da Ada: "+pessoaAda.segredoPessoal);

pessoaJG.falar("James Gosling diria: Java e foi criada com OO em mente. Criei a linguagem "+pessoaJG.lang);
console.log(pessoaJG.url);


pessoaYM.falar("Yukihiro falando: o Ruby pode nao ser rapida, mas e a mais inteligente. Eu que criei a linguagem "+pessoaYM.lang);
console.log(pessoaYM.url);


console.dir(pessoaAda);
console.dir(pessoaJG);
console.dir(pessoaYM);

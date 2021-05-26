console.log(">>> >>> ProfessorClass.js carregado com sucesso!!!");

class Professor extends Pessoa{
    darAula(str){
        this.falar(this.nome+" falando na aula...");
        console.log(this.nome+" expondo material sobre "+ this.lang);        
    }
}

let profAda = new Professor("Ada Lovelace","O Babbage e fraco na parte algoritmos rsrsr, eu tenho que fazer tudo grr..");
let profJG = new Professor("James Gosling","");
let profYM = new Professor("Yukihiro Matsumoto");

profAda.lang = "Ada";
profJG.lang = "Java";
profYM.lang = "Ruby";

profAda.url = "https://pt.wikipedia.org/wiki/Ada_Lovelace";
profJG.url = "https://pt.wikipedia.org/wiki/James_Gosling";
profYM.url = "https://pt.wikipedia.org/wiki/Yukihiro_Matsumoto";


profAda.falar("Ada falando: O primeiro programador foi uma programadora. Criei a linguagem "+profAda.lang);
console.log(profAda.url);
console.log("Segredo de nascenca da Ada: "+profAda.segredoPessoal);

profJG.falar("James Gosling diria: Java e foi criada com OO em mente. Criei a linguagem "+profJG.lang);
console.log(profJG.url);


profYM.falar("Yukihiro falando: o Ruby pode nao ser rapida, mas e a mais inteligente. Eu que criei a linguagem "+profYM.lang);
console.log(profYM.url);


console.dir(profAda);
console.dir(profJG);
console.dir(profYM);

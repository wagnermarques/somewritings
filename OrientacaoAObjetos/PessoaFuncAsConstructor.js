let Pessoa = function (nome){
    this.url;

    this.nome = nome; 
    this.lang = "--";
    
    this.falar = function(str){
        console.log(str);
    };    
}

let PessoaAda = new Pessoa("Ada Lovelace");
let PessoaJG = new Pessoa("James Gosling");
let PessoaYM = new Pessoa("Yukihiro Matsumoto");

PessoaAda.lang = "Ada";
PessoaJG.lang = "Java";
PessoaYM.lang = "Ruby"

console.dir(PessoaAda);
console.dir(PessoaJG);
console.dir(PessoaYM);

PessoaAda.falar("fala da Ada: Quer aprender algo sobre a linugagem "+PessoaAda.lang+"? Acesse: https://learn.adacore.com/courses/intro-to-ada/index.html");
PessoaJG.falar("James Gosling speaking: Vc ta aprendendo OO com js? Acho que "+PessoaJG.lang+ " e ate mais facil heinn rsrsr");
PessoaYM.falar("Yukihiro na area:  a linuguagem "+ PessoaYM.lang+" tambem e uma linguagem OO, vc sabia?");

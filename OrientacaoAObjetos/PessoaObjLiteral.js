let pessoaAda = {};
pessoaAda.nome = "Ada Lovelace";
pessoaAda.lang = "Ada";
pessoaAda.falar = function(str){
    console.log(str);
};

let pessoaJG = {
    falar : function(str){
        console.log(str);
    }
};
pessoaJG.nome = "James Gosling";
pessoaJG.lang = "java";


let pessoaYM = {};
pessoaYM.nome = "Yukihiro Matsumoto";
pessoaYM.lang = "ruby";
pessoaYM.falar = function(str){
    console.log(str);
};

console.dir(pessoaAda);
console.dir(pessoaJG);
console.dir(pessoaYM);

pessoaAda.falar("A Ada.. Hiness desculpa meu ingles... ");
pessoaJG.falar("James Gosling... vc viu que vc devine um metodo para o objeto de maneiras diferentes? isso aqui no literal, porque ainda tem com function com o contrutor e class heinn.. e flexivel de mais isos ai.. sera que e bom?");
pessoaYM.falar("Yukihiro na area.. ");

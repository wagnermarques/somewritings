console.log("=>=>=> ProfessorFuncAsConstructor.js carregado com sucesso!!!");

let Professor = function (nome){
    Pessoa.call(this,nome);
    this.darAula = function(aquelaStrQueOMetodoOriginalFalaRecebia){        
        this.falar(this.nome+" falando na aula...");
        console.log(this.nome+" expondo material sobre "+ this.lang);
    }
}


//Professor.prototype = Object.create(Pessoa);
Professor.prototype = Object.create(Pessoa);


//Professor.prototype.constructor = Pessoa;
//Professor.prototype.falar = Pessoa.falar;
let profAda = new Professor("Ada Lovelace");
let profJG = new Professor("James Gosling");
let profYM = new Professor("Yukihiro Matsumoto");


console.dir(profAda);
console.dir(profJG);
console.dir(profYM);

profAda.darAula("essa e a aula heinn...");
profJG.darAula("falei e disse (JG) ");
profYM.darAula("ruby he ruby... (YM)");


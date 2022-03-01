console.log("->->->ProfessorObjLiteral.js carregado com sucesso!!!");

let profAda = Object.create(pessoaAda);;
profAda.darAula = function(aquelaStrQueOMetodoOriginalFalaRecebia){
    this.falar(this.nome+" falando entusiasmada na aula");
    console.log(this.nome+" expondo material sobre... Advidinha..., sobre "+this.lang+" e claro!!!");
}

let profJG = Object.create(pessoaJG);;
profJG.darAula = function(aquelaStrQueOMetodoOriginalFalaRecebia){
    this.falar(this.nome+" falando na aula...");
    console.log(this.nome+" expondo material da aula sobre "+this.lang);
}

let profYM = Object.create(pessoaYM);;
profYM.darAula = function(aquelaStrQueOMetodoOriginalFalaRecebia){
    this.falar(this.nome+" falando na aula...");
    console.log(this.nome+" expondo material sobre "+ this.lang);
}

console.dir(profAda);
console.dir(profJG);
console.dir(profYM);

profAda.darAula("essa e a aula heinn...");
profJG.darAula("falei e disse (JG) ");
profYM.darAula("ruby he ruby... (YM)");

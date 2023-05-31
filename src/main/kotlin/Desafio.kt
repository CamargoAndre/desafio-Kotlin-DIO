
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val id: Int)

data class ConteudoEducacional(var nome: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}


fun main(){

    val conteudoBasico = ConteudoEducacional(nome = Nivel.BASICO)
    val conteudoIntermediario = ConteudoEducacional(nome = Nivel.INTERMEDIARIO)
    val conteudoDificil = ConteudoEducacional(nome = Nivel.DIFICIL)

    val conteudos = mutableListOf<ConteudoEducacional>(
        conteudoBasico, conteudoIntermediario, conteudoDificil
    )
    val formacaoKotlin = Formacao("Kotlin", conteudos)



    val usuario1 = Usuario("Andre", 1)
    val usuario2 = Usuario("João", 2)


    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    println("Curso ${formacaoKotlin.nome}")

    println("Conteudos do Curso: ")
    formacaoKotlin.conteudos.forEach{
        c -> println("${c.nome} de duração ${c.duracao}")
    }

    println("Alunos Inscritos:")
   formacaoKotlin.inscritos.forEach{
       i -> println("Usuario id: ${i.id} nome: ${i.nome}")
   }



}

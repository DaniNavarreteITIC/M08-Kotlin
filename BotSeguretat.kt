data class Persona(
    val name: String,
    val age: Int,
    val entreteniments: List<String>
)

fun botDeSeguretat(persona: Persona, elmeuNom: String) {
    if (persona.name != elmeuNom) {
        println("Error: El nom no es el teu. Accés denegat!")
        return
    } else {
        println("Nom correcte: ${persona.name}.")
    }
    when (persona.age) {
        in 0..13 -> {
            println("Ets massa petita/d (${persona.age} anys). Accés denegat!")
            return
        }
        in 14..17 -> {
            println("Tens ${persona.age} anys, Necessites permís parental.")
        }
        else -> {
            if (persona.age >= 18) {
                println("Ets major d'edat (${persona.age} anys). Accés concesso!")
            } else {
                println("Edat no vàlida.")
                return
            }
        }
    }

    println("\nEntreteniments autoritzats (A-L):")
    val filtrats = persona.entreteniments
        .sortedWith(String.CASE_INSENSITIVE_ORDER)
        .filter { item ->
            val lletra = item.trim().uppercase().firstOrNull()
            lletra != null && lletra in 'A'..'L'
        }
    for (item in filtrats) {
        println("- $item")
    }
}
fun main() {
    val elMeuNom = "Dani"
    val jo = Persona(
        name = "Dani",
        age = 20,
        entreteniments = listOf("Ajedrez","Cinema", "Escalada", "Lectura", "Musica", "Teatre")
    )
    botDeSeguretat(jo,elMeuNom)
}
package com.pluralsight.advancedjava.examples.example01;

import java.util.Objects;

/**
 * Simulation de ce que le compilateur Java génère à partir du record {@link Product}.
 * <p>
 * Quand vous écrivez {@code public record Product(...)}, le compilateur Java transforme ce code
 * en une classe immuable qui ressemble beaucoup à celle-ci. C'est une approximation, mais
 * cela montre tout le code "répétitif" (boilerplate) que les records vous épargnent.
 * <p>
 * Notez que tous les records héritent implicitement de la classe {@code java.lang.Record}.
 */
public final class Product_ /* extends java.lang.Record */ {

    // 1. Des champs privés et finaux sont générés pour chaque composant.
    // Ils sont 'final' pour garantir l'immuabilité.
    private final long id;
    private final String name;
    private final String description;

    // 2. Un constructeur public, appelé "constructeur canonique", est généré.
    // Il prend un argument pour chaque champ et les initialise.
    public Product_(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // 3. Des méthodes d'accès (getters) sont générées.
    // Notez que pour les records, les méthodes ont le même nom que les champs (ex: id()),
    // et non pas le style classique des JavaBeans (ex: getId()).
    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    // 4. Les méthodes additionnelles que vous avez ajoutées dans le record sont simplement copiées.
    public boolean hasDescription() {
        return description != null && !description.isBlank();
    }

    // 5. Les méthodes equals(), hashCode() et toString() sont générées automatiquement.
    // Elles comparent tous les champs, ce qui est le comportement attendu pour un objet de données.

    /**
     * Compare cet objet à un autre. Le `instanceof` avec pattern matching est une syntaxe moderne.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Product_ other &&
                this.id == other.id && Objects.equals(this.name, other.name) && Objects.equals(this.description, other.description);
    }

    /**
     * Calcule le code de hachage basé sur tous les champs.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    /**
     * Fournit une représentation textuelle claire de l'objet.
     */
    @Override
    public String toString() {
        return "Product[id=" + id + ", name=" + name + ", description=" + description + "]";
    }
}

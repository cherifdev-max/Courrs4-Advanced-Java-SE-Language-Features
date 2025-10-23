package com.pluralsight.advancedjava.examples.example01;

/**
 * Classe d'exemple pour démontrer la création et l'utilisation d'un record.
 * <p>
 * Cette classe contient une méthode {@code main} qui montre comment instancier
 * le record {@link Product} et comment appeler ses méthodes d'accès et ses méthodes additionnelles.
 */
public class RecordsExample02 {

    /**
     * Le point d'entrée du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {
        // Créer une instance d'un record fonctionne exactement de la même manière
        // que de créer une instance d'une classe normale, en utilisant le mot-clé 'new'.
        var product = new Product(100123L, "Apples", "Tasty red apples");

        // Les méthodes d'accès (getters) pour un record ont le même nom que les composants
        // (par exemple, product.name()) et non des noms qui commencent par 'get' comme pour les JavaBeans (product.getName()).
        System.out.printf("Le produit '%s' a l'ID : %d%n", product.name(), product.id());

        // On peut aussi appeler les méthodes additionnelles que nous avons définies dans le record.
        System.out.println("Ce produit a-t-il une description ? " + product.hasDescription());
    }
}

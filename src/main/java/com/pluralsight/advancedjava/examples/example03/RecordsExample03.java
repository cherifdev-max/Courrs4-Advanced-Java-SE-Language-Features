package main.java.com.pluralsight.advancedjava.examples.example03;

/**
 * Classe d'exemple qui démontre un problème potentiel (un piège)
 * lors de la redéfinition des méthodes d'accès d'un record.
 */
public class RecordsExample03 {

    /**
     * Le point d'entrée du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        // Dans le record Customer, la méthode d'accès pour le composant 'name' est redéfinie.
        // Si le champ 'name' interne est null, la méthode name() retourne "anonymous".
        var customer = new Customer(500567L, null, null);

        // Comme prévu, l'appel à la méthode redéfinie retourne "anonymous".
        System.out.println("customer.name() retourne : " + customer.name());

        // ATTENTION, voici le piège :
        // Si vous redéfinissez une méthode d'accès pour qu'elle retourne autre chose que la valeur du champ,
        // et que vous faites une copie du record comme ci-dessous, la copie ne sera PAS égale à l'original.
        // Pourquoi ?
        // 1. Pour créer la copie, on appelle `customer.name()`, qui retourne la chaîne "anonymous".
        // 2. La copie est donc créée avec la valeur "anonymous" dans son champ 'name'.
        // 3. L'original, lui, a toujours `null` dans son champ 'name' interne.
        // 4. La méthode .equals() générée par le compilateur compare les champs internes, pas le résultat des méthodes.
        // Elle comparera donc `null` (de l'original) avec `"anonymous"` (de la copie), et conclura qu'ils ne sont pas égaux.
        // C'est considéré comme un mauvais style de programmation car cela brise le contrat d'un objet de données.
        var copy = new Customer(customer.id(), customer.name(), customer.email());

        System.out.println("La copie devrait être égale à l'original, mais copy.equals(customer) retourne : " + copy.equals(customer));

        // L'affichage de toString() rend le problème évident :
        System.out.println("Original: " + customer);
        System.out.println("Copie   : " + copy);
    }
}

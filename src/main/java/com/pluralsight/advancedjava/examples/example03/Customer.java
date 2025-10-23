package main.java.com.pluralsight.advancedjava.examples.example03;

/**
 * Exemple d'un record où une méthode d'accès générée est redéfinie (overridden).
 * <p>
 * Il est possible de fournir votre propre implémentation pour les méthodes
 * que le compilateur génère normalement pour vous, comme les méthodes d'accès.
 * Cela peut être utile pour ajouter une logique personnalisée, comme fournir une valeur par défaut.
 *
 * @param id    L'identifiant unique du client.
 * @param name  Le nom du client.
 * @param email L'adresse e-mail du client.
 */
public record Customer(long id, String name, String email) {

    // Vous pouvez redéfinir les méthodes d'accès générées par le compilateur.
    // C'est une bonne idée d'utiliser l'annotation @Override lorsque vous le faites
    // pour indiquer au compilateur que cette méthode est destinée à remplacer une méthode existante
    // (même s'il s'agit d'une méthode générée).

    /**
     * Redéfinition de la méthode d'accès pour le nom.
     * <p>
     * Si le nom est nul ou vide, cette méthode retourne "anonymous" comme valeur par défaut.
     * Sinon, elle retourne le nom fourni.
     *
     * @return Le nom du client, ou "anonymous" si le nom est absent.
     */
    @Override
    public String name() {
        return name != null && !name.isBlank() ? name : "anonymous";
    }

    // Attention : Il y a un problème avec ce record, qui sera démontré dans RecordsExample03.
    // Le problème est que la méthode equals() générée par le compilateur continuera
    // d'utiliser la valeur du champ 'name' brut, et non la valeur modifiée par cette méthode.
}

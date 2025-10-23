/*
 * This code is part of the course "Java SE Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2024 by Jesper de Jong (jesper@jdj-it.com).
 */
package com.pluralsight.advancedjava.examples.example01;

import java.util.Objects;

/**
 * Représente un produit avec un identifiant, un nom et une description.
 * <p>
 * C'est un exemple de **classe immuable**. Une fois qu'un objet ProductCls est créé,
 * ses données (id, nom, description) ne peuvent plus jamais être modifiées.
 * C'est une bonne pratique pour créer des objets de données fiables et sûrs,
 * surtout dans des applications multi-threads.
 *
 * @author Jesper de Jong
 */
public final class ProductCls { // Le mot-clé 'final' signifie que cette classe ne peut pas être étendue (on ne peut pas en hériter).

    // --- CHAMPS (FIELDS) ---
    // Ce sont les variables qui stockent les données de notre produit.
    // Ils sont 'private' pour que seul le code à l'intérieur de cette classe puisse y accéder directement.
    // Ils sont 'final' pour garantir qu'une fois assignés dans le constructeur, ils ne pourront plus jamais changer.

    /**
     * L'identifiant unique du produit.
     */
    private final long id;

    /**
     * Le nom du produit.
     */
    private final String name;

    /**
     * Une description détaillée du produit.
     */
    private final String description;

    // --- CONSTRUCTEUR ---
    // C'est une méthode spéciale appelée pour créer une nouvelle instance (un nouvel objet) de ProductCls.
    // Elle prend une valeur pour chaque champ et les initialise.

    /**
     * Construit un nouveau produit avec les détails spécifiés.
     *
     * @param id          L'identifiant du produit.
     * @param name        Le nom du produit.
     * @param description La description du produit.
     */
    public ProductCls(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // --- GETTERS ---
    // Ce sont des méthodes publiques qui permettent au code extérieur de LIRE les valeurs
    // des champs privés. Comme il n'y a pas de méthodes 'setters' (ex: setId),
    // on renforce l'immuabilité : on peut voir les données, mais pas les changer.

    /**
     * @return L'identifiant du produit.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Le nom du produit.
     */
    public String getName() {
        return name;
    }

    /**
     * @return La description du produit.
     */
    public String getDescription() {
        return description;
    }

    // --- MÉTHODES UTILITAIRES ---
    // Ces méthodes sont des redéfinitions (@Override) de méthodes de la classe Object,
    // la classe mère de tous les objets en Java. C'est une bonne pratique de les fournir
    // pour que nos objets se comportent correctement dans des collections (comme les listes ou les maps).

    /**
     * Compare cet objet produit à un autre objet pour voir s'ils sont égaux.
     * Deux produits sont considérés comme égaux s'ils ont le même id, le même nom et la même description.
     *
     * @param o L'objet à comparer avec celui-ci.
     * @return {@code true} si les objets sont égaux, sinon {@code false}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si c'est la même instance en mémoire, ils sont égaux.
        if (o == null || getClass() != o.getClass()) return false; // Si l'autre objet n'est pas un ProductCls, ils ne sont pas égaux.
        ProductCls that = (ProductCls) o; // On le "caste" en ProductCls pour pouvoir comparer les champs.
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    /**
     * Calcule un "code de hachage" pour cet objet.
     * C'est un nombre entier qui est utilisé par certaines collections (comme HashSet ou HashMap)
     * pour stocker et retrouver rapidement l'objet.
     * La règle est que si deux objets sont égaux (selon .equals()), ils DOIVENT avoir le même hashCode.
     *
     * @return Le code de hachage pour cet objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    /**
     * Retourne une représentation textuelle de l'objet.
     * C'est très utile pour le débogage, par exemple quand on fait System.out.println(monProduit).
     *
     * @return Une chaîne de caractères décrivant l'objet produit.
     */

}

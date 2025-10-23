/*
 * This code is part of the course "Java SE Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2024 by Jesper de Jong (jesper@jdj-it.com).
 */
package com.pluralsight.advancedjava.examples.example01;

/**
 * Exemple d'un record qui contient des méthodes supplémentaires.
 * <p>
 * En plus de tous les membres générés automatiquement (constructeur, getters, equals, etc.),
 * vous pouvez ajouter votre propre logique à un record, comme des méthodes utilitaires.
 *
 * @param id          L'identifiant unique du produit.
 * @param name        Le nom du produit.
 * @param description La description détaillée du produit.
 */
public record Product(long id, String name, String description) {

    // Vous pouvez ajouter des méthodes supplémentaires à un record, 
    // tout comme vous le feriez dans une classe normale.
    // Cela permet d'ajouter de la logique métier directement liée aux données du record.

    /**
     * Vérifie si le produit a une description valide (non-nulle et non-vide).
     * 
     * @return {@code true} si la description existe et n'est pas vide, sinon {@code false}.
     */
    public boolean hasDescription() {
        // On vérifie d'abord que la description n'est pas null pour éviter une NullPointerException,
        // puis on vérifie qu'elle n'est pas composée uniquement d'espaces.
        return description != null && !description.isBlank();
    }
}
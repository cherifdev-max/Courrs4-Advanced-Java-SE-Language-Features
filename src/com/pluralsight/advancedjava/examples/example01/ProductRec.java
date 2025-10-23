/*
 * This code is part of the course "Java SE Advanced Language Features" for Pluralsight.
 *
 * Copyright (C) 2024 by Jesper de Jong (jesper@jdj-it.com).
 */
package com.pluralsight.advancedjava.examples.example01;

/**
 * Représente un produit en utilisant un <strong>record</strong> Java.
 * <p>
 * Un record est une manière très concise de créer une classe immuable.
 * Cette seule ligne de code génère automatiquement pour vous :
 * <ul>
 *     <li>Des champs privés et finaux pour {@code id}, {@code name}, et {@code description}.</li>
 *     <li>Un constructeur public qui accepte les trois champs.</li>
 *     <li>Des méthodes d'accès publiques (getters) pour chaque champ (ex: {@code id()}).</li>
 *     <li>Les méthodes {@code equals()}, {@code hashCode()}, et {@code toString()} correctement implémentées.</li>
 * </ul>
 * Ce record a exactement la même fonctionnalité que la classe {@link ProductCls}, mais avec beaucoup moins de code.
 *
 * @param id          L'identifiant unique du produit.
 * @param name        Le nom du produit.
 * @param description La description détaillée du produit.
 */
public record ProductRec(long id, String name, String description) {
    // C'est tout ! Le compilateur Java fait tout le travail pour nous.
    // Pas besoin d'écrire manuellement les champs, le constructeur, les getters,
    // ou les méthodes equals, hashCode et toString.
}

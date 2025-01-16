/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.creational.factory;

public class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }
}

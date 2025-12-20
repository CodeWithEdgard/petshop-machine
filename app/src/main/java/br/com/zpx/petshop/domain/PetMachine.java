package br.com.zpx.petshop.domain;

public class PetMachine {

    private int nivelAtualAgua = 0;
    private int nivelAtualShampoo = 0;
    private int quantAtualPet = 0;
    private boolean petEstaLimpo;

    public PetMachine() {
    }

    public PetMachine(int nivelAtualAgua, int nivelAtualShampoo, int quantAtualPet, boolean petEstaLimpo) {
        this.nivelAtualAgua = nivelAtualAgua;
        this.nivelAtualShampoo = nivelAtualShampoo;
        this.quantAtualPet = quantAtualPet;
        this.petEstaLimpo = petEstaLimpo;
    }

    public int getNivelAtualAgua() {
        return this.nivelAtualAgua;
    }

    public void setNivelAtualAgua(int nivelAtualAgua) {
        this.nivelAtualAgua = nivelAtualAgua;
    }

    public int getNivelAtualShampoo() {
        return this.nivelAtualShampoo;
    }

    public void setNivelAtualShampoo(int nivelAtualShampoo) {
        this.nivelAtualShampoo = nivelAtualShampoo;
    }

    public int getQuantAtualPet() {
        return this.quantAtualPet;
    }

    public void setQuantAtualPet(int quantAtualPet) {
        this.quantAtualPet = quantAtualPet;
    }

    public boolean getPetEstaLimpo() {
        return this.petEstaLimpo;
    }

    public void setPetEstaLimpo(boolean petEstaLimpo) {
        this.petEstaLimpo = petEstaLimpo;
    }
}

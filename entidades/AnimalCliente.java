package entidades;

public class AnimalCliente {
    Integer idAnimalCliente, idAnimal, idCliente;

    public AnimalCliente(Integer idAnimalCliente, Integer idAnimal, Integer idCliente) {
        this.idAnimalCliente = idAnimalCliente;
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
    }

    public Integer getIdAnimalCliente() {
        return idAnimalCliente;
    }

    public void setIdAnimalCliente(Integer idAnimalCliente) {
        this.idAnimalCliente = idAnimalCliente;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
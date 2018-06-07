public class cubo extends cuadrado{
    cuadrado c = new cuadrado();

    public float calcularVolumen(float lado){
        float volumen;

        volumen = lado * c.calcularArea(lado);

        return volumen;

    }
    public float calcularPerimetro(float lado){
        float perimetro;

        perimetro = 3 * c.calcularPerimetro(lado);

        return perimetro;
    }
}

import java.util.Scanner;

public class EXAMEN3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de estudiantes: ");
        int numEstudiantes = scanner.nextInt();

        if (numEstudiantes <= 0) {
            System.out.println("El número de estudiantes debe ser mayor a 0.");
            return;
        }

        double[] calificaciones = new double[numEstudiantes];

        for (int i = 0; i < numEstudiantes; i++) {
            double calificacion;
            do {
                System.out.print("Ingrese la calificación del estudiante " + (i + 1) + " (0-100): ");
                calificacion = scanner.nextDouble();
                if (calificacion < 0 || calificacion > 100) {
                    System.out.println("La calificación debe estar entre 0 y 100.");
                }
            } while (calificacion < 0 || calificacion > 100);
            calificaciones[i] = calificacion;
        }

        double promedio = calcularPromedio(calificaciones);
        int mayoresAlPromedio = contarCalificacionesMayores(calificaciones, promedio);
        double calificacionMasAlta = obtenerCalificacionMasAlta(calificaciones);
        double calificacionMasBaja = obtenerCalificacionMasBaja(calificaciones);

        System.out.println("\nResultados:");
        System.out.printf("Promedio de calificaciones: %.2f%n", promedio);
        System.out.println("Número de calificaciones mayores o iguales al promedio: " + mayoresAlPromedio);
        System.out.println("Calificación más alta: " + calificacionMasAlta);
        System.out.println("Calificación más baja: " + calificacionMasBaja);
    }

    public static double calcularPromedio(double[] calificaciones) {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    public static int contarCalificacionesMayores(double[] calificaciones, double promedio) {
        int contador = 0;
        for (double calificacion : calificaciones) {
            if (calificacion >= promedio) {
                contador++;
            }
        }
        return contador;
    }

    public static double obtenerCalificacionMasAlta(double[] calificaciones) {
        double max = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion > max) {
                max = calificacion;
            }
        }
        return max;
    }

    public static double obtenerCalificacionMasBaja(double[] calificaciones) {
        double min = calificaciones[0];
        for (double calificacion : calificaciones) {
            if (calificacion < min) {
                min = calificacion;
            }
        }
        return min;
    }
}


public class QuantityMeasurementApp {

    public static <U extends IMeasurable> void demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
        System.out.println(q1 + " == " + q2 + " → " + q1.equals(q2));
    }

    public static <U extends IMeasurable> void demonstrateConversion(Quantity<U> q, U target) {
        System.out.println(q + " → " + q.convertTo(target));
    }

    public static <U extends IMeasurable> void demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U target) {
        System.out.println(q1 + " + " + q2 + " → " + q1.add(q2, target));
    }

    public static void main(String[] args) {

        // ✅ VOLUME (UC11)
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v3 = new Quantity<>(1, VolumeUnit.GALLON);

        demonstrateEquality(v1, v2); // true
        demonstrateConversion(v1, VolumeUnit.MILLILITRE); // 1000
        demonstrateAddition(v1, v2, VolumeUnit.LITRE); // 2 L

        demonstrateConversion(v3, VolumeUnit.LITRE); // ~3.78541
        demonstrateAddition(v1, v3, VolumeUnit.MILLILITRE); // ~4785.41
    }
}
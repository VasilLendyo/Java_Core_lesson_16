package Min;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		// MIN
		Class pc = Student.class;

		String name = pc.getName();
		System.out.println("Name of class: \n" + name);

		System.out.println();

		String simpleName = pc.getSimpleName();
		System.out.println("Simple name of class: \n" + simpleName);

		System.out.println();

		int modifiers = pc.getModifiers();
		String modifierString = Modifier.toString(modifiers);
		System.out.println("Class modifier: \n" + modifierString);

		System.out.println();

		Package classPackage = pc.getPackage();
		System.out.println("Package of class: \n" + classPackage);

		System.out.println();

		Class superclass = pc.getSuperclass();
		System.out.println("Super class: \n" + superclass);

		System.out.println();

		Class[] interfaces = pc.getInterfaces();
		System.out.println("Interfaces: \n" + Arrays.toString(interfaces));

		System.out.println();

		Constructor[] constructors = pc.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Constructor constructor = constructors[i];
			System.out.println("Constructor of class: \n" + constructor);
		}

		System.out.println();

		Class[] parameterTypes = constructors[1].getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class class1 = parameterTypes[i];
			System.out.println("Type of constructor: \n" + class1);
		}

		System.out.println();

		Constructor<Student> singleConstructor = pc.getConstructor(String.class, int.class);
		System.out.println("Single constructor: \n" + singleConstructor);
		Student newInstance = singleConstructor.newInstance("Vasyl", 5);
		System.out.println("Reflection Student: \n" + newInstance);

		System.out.println();

		Field[] fields = pc.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("Felds of class: \n" + field);
		}

		System.out.println();

		Method[] methods = pc.getMethods();
		System.out.println("Methods of the class: ");
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}

		System.out.println();

		System.out.println("Default: ");
		System.out.println(newInstance);

		System.out.println();

		// MAX
		System.out.println("Changed level: ");
		Field privateLevel = fields[1];
		privateLevel.setAccessible(true);
		privateLevel.set(newInstance, 3);
		System.out.println(newInstance);

		System.out.println();

		System.out.println("Changed name: ");
		Field privateName = fields[0];
		privateName.setAccessible(true);
		privateName.set(newInstance, "Katrin");
		System.out.println(newInstance);

		methods[6].invoke(newInstance);
		methods[7].invoke(newInstance);
	}
}

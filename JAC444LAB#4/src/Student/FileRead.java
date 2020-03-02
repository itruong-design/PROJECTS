package Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class FileRead {
	private File file;

	public FileRead (File file) throws FileReadException {

		if (file.exists()) {
			this.file = file;
		} else {
			throw new FileReadException("File could not be found");
		}
	}

	public Student deserializeObject() throws IOException, ClassNotFoundException, StreamCorruptedException {
		FileInputStream fis = new FileInputStream(this.file.getName());
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student obj = null;
		obj = (Student) ois.readObject();
		ois.close();
		return obj;

	}

}


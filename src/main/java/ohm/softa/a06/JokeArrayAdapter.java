package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;

import java.io.IOException;

public class JokeArrayAdapter extends TypeAdapter<Joke[]> {
	private final Gson gson;

	public JokeArrayAdapter() {
		gson = new Gson();
	}
	@Override
	public Joke[] read(JsonReader reader) throws IOException {

		Joke[] result = null;
		reader.beginObject();
		while (reader.hasNext()) {
			switch (reader.nextName()){
				case "total":
					reader.skipValue();
					break;

				case "result":
					result = gson.fromJson(reader, Joke[].class);
					break;
			}
		}
		reader.endObject();
		return result;
	}
	@Override
	public void write(JsonWriter writer, Joke[] inst) throws IOException {
		// not needed here
	}
}

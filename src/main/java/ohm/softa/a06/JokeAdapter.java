package ohm.softa.a06;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter {
	@Override
	public Object read(JsonReader reader) throws IOException {
		Joke joke = new Joke();
		reader.beginObject();

		while (reader.hasNext()){
			switch (reader.nextName()) {
				case "cathegories":
					joke.setRubrics(reader.nextString().split(","));
					break;

				case "id":
					joke.setIdentifier(reader.nextString());
					break;

				case "value":
					joke.setContent(reader.nextString());
			}
		}
		return joke;
	}

	@Override
	public void write(JsonWriter writer, Object inst) throws IOException {
		writer.beginObject();
		writer.name("id").value(((Joke) inst).getIdentifier());
		writer.name("content").value(((Joke) inst).getContent());
		writer.name("cathegories").value(StringUtils.join(((Joke) inst).getRubrics(), ";"));
		writer.endObject();
	}
}

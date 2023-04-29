package ohm.softa.a06;


import ohm.softa.a06.model.Joke;

public interface CNJDBApi {
	@GET("/jokes/random");

	Call<Joke>


}

package com.example.controller;

import com.example.model.Movie;
import com.example.service.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/api/movie/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieController {
    @Inject
    MovieService movieService;

    @POST
    @Path("addmovie")
    public Response addMovie(Movie movie){
       try{
           return Response.ok(movieService.addMovie(movie)).build();
       }catch (Exception e){
           return Response.status(Response.Status.BAD_REQUEST).build();
       }
    }
    @GET
    @Path("listall")
    public Response listAll(){
        return Response.ok(movieService.findMovies()).build();
    }
    @DELETE
    @Path("delete/{id}")
    public Response deleteMovie(@PathParam("id") Long id){

        if(movieService.deleteMovieById(id)) {
            return Response.ok("Movie deleted from system").build();
        }
        return Response.noContent().build();
    }
    @PUT
    @Path("update/{id}")
    public Response updateMovie(@PathParam("id") Long id,Movie movie){
       try {
           return Response.ok(movieService.updateMovieById(id,movie)).build();
       }catch (Exception e){
           return Response.noContent().build();
       }
    }
    @GET
    @Path("findbyid/{id}")
    public Response findById(@PathParam("id") Long id) throws NotFoundException{
        try {
            return Response.ok(movieService.findMovieById(id)).build();
        }
        catch (Exception e){
            throw new RuntimeException("Movie not found");
        }
    }

    @POST
    @Path("affect/{idmv}/{idauth}")
    public Response affectMovieToAuth(@PathParam("idmv") Long idmv,@PathParam("idauth") Long idauth) throws Exception{
        try{
            return Response.ok(movieService.affectMovieToAuthor(idmv,idauth)).build();
        }catch (Exception e){
            throw new Exception("Movie Not affected | " + e.getMessage());
        }
    }
}

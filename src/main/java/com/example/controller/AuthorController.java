package com.example.controller;

import com.example.model.Author;
import com.example.service.AuthorService;
import com.example.service.MovieService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/author/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorController {
    final AuthorService authorService;
    final MovieService movieService;
    public AuthorController(AuthorService authorService, MovieService movieService) {
        this.authorService = authorService;
        this.movieService = movieService;
    }



    @POST
    @Path("addauthor")
    public Response addAuthor(Author author){
        return Response.ok(authorService.addAuthor(author)).build();
    }
    @GET
    @Path("listall")
    public Response getAll(){
        return Response.ok(authorService.findAuthors()).build();
    }
    @DELETE
    @Path("delete/{id}")
    public Response deleteByid(@PathParam("id") Long id){
        return Response.ok(authorService.deleteAuthorById(id)).build();
    }
    @GET
    @Path("find/{id}")
    public Response getById(@PathParam("id") Long id){
        return Response.ok(authorService.findAuthorById(id)).build();
    }
    @PUT
    @Path("update/{id}")
    public Response updateById(@PathParam("id") Long id, Author author){
        return Response.ok(authorService.updateAuthorById(id,author)).build();
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

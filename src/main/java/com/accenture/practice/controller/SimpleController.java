package com.accenture.practice.controller;

import com.accenture.practice.models.Playlist;
import com.accenture.practice.models.Album;
import com.accenture.practice.repositories.AlbumRepository;
import com.accenture.practice.repositories.PlaylistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    // @GetMapping("/")
    // public String homePage(Model model) {
    //     Album album = albumRepository.findById(1L).get();
    //     model.addAttribute("appName", album.getTitle());
    //     return "home";
    // }

    @GetMapping("/Playlist/{id}")
    public String homePage1(@PathVariable Long id, Model model) {
        Playlist playlist = playlistRepository.findById(id).get();  //findById(1L).get();
        model.addAttribute("appName", playlist.getName());
        return "home";
    }

   
    
}

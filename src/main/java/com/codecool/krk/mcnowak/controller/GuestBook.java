package com.codecool.krk.mcnowak.controller;

import com.codecool.krk.mcnowak.dao.EntryRepository;
import com.codecool.krk.mcnowak.models.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class GuestBook {

    private EntryRepository entryRepository;

    public GuestBook(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @GetMapping("")
    public String showPage (ModelMap model) {


        Iterable<Entry> elementList = this.entryRepository.findAll();
        model.addAttribute("entries", elementList);
        return "index";
    }

    @PostMapping("")
    public String add(@RequestBody MultiValueMap<String,String> formData, ModelMap model){
        String name = formData.getFirst("name");
        String content = formData.getFirst("content");
        Entry entry = new Entry(content, name);

        this.entryRepository.save(entry);

        return showPage(model);
    }

}

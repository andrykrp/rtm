package controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import services.CategoryService;

@Singleton
public class DictionaryController {
    @Inject
    private CategoryService categoryService;

//    public Result listCategories() {
//        return Results.html().render("categories", dictionaryService.getAllRootCategories());
//    }
}

package eus.blankcard.decklearn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eus.blankcard.decklearn.models.UserModel;
import eus.blankcard.decklearn.repository.user.UserRepository;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{username}")
    public String getProfile(@PathVariable("username") String username, HttpServletRequest req,
            HttpServletResponse response) {
        UserModel user = null;

        user = userRepository.findByUsername(username);
        if (user != null) {
            req.setAttribute("user", user);

            req.setAttribute("followers", user.getFollowers().size());
            req.setAttribute("following", user.getFollowed().size());
            req.setAttribute("userDecks", user.getDecks());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();

            if (currentPrincipalName.equals(username)) {
                return "profile";
            } else {
                return "profile_visit";
            }

        } else {
            response.setStatus(404);
            return "error";
        }
    }

    @GetMapping("/{username}/followers")
    public String getFollowers(@PathVariable("username") String username, HttpServletRequest req,
            HttpServletResponse response) {
        UserModel user = userRepository.findByUsername(username);

        req.setAttribute("followers", user.getFollowers());

        return "following";
    }

    @GetMapping("/{username}/following")
    public String getFollowing(@PathVariable("username") String username, HttpServletRequest req,
            HttpServletResponse response) {
        UserModel user = userRepository.findByUsername(username);

        req.setAttribute("followers", user.getFollowed());
        
        return "following";
    }

    @PostMapping("/{username}/follow")
    public String follow() {
        return "redirect:/profile";
    }
}
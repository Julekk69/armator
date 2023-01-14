package bdbt_projekt.Armator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/main").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index_pracownik").setViewName("index_pracownik");
        registry.addViewController("/index_bandera").setViewName("index_bandera");
        registry.addViewController("/new_form").setViewName("new_form");
        registry.addViewController("/edit_form").setViewName("edit_form");
        registry.addViewController("/index_adres").setViewName("index_adres");
        registry.addViewController("/index_usluga").setViewName("index_usluga");
        registry.addViewController("/edit_formadres").setViewName("edit_formadres");
        registry.addViewController("/new_formadres").setViewName("new_formadres");
        registry.addViewController("/index_wlasciciel").setViewName("index_wlasciciel");
        registry.addViewController("/index_klient").setViewName("index_klient");
        registry.addViewController("/index_armator").setViewName("index_armator");
        registry.addViewController("/index_port").setViewName("index_port");
        registry.addViewController("/index_statek").setViewName("index_statek");
        registry.addViewController("/index_statekuser").setViewName("index_statekuser");
        registry.addViewController("/new_formwlasciciel").setViewName("new_formwlasciciel");
        registry.addViewController("/new_formklient").setViewName("new_formklient");
        registry.addViewController("/new_formusluga").setViewName("new_formusluga");
        registry.addViewController("/new_formport").setViewName("new_formport");
        registry.addViewController("/new_formarmator").setViewName("new_formarmator");
        registry.addViewController("/new_formpracownik").setViewName("new_formpracownik");
        registry.addViewController("/new_formstatek").setViewName("new_formstatek");
        registry.addViewController("/edit_formwlasciciel").setViewName("edit_formwlasciciel");
        registry.addViewController("/edit_formklient").setViewName("edit_formklient");
        registry.addViewController("/edit_formusluga").setViewName("edit_formusluga");
        registry.addViewController("/edit_formport").setViewName("edit_formport");
        registry.addViewController("/edit_formstatek").setViewName("edit_formstatek");
        registry.addViewController("/edit_formarmator").setViewName("edit_formarmator");
        registry.addViewController("/edit_formpracownik").setViewName("edit_formpracownik");



        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Controller
    public class DashboardController {

        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/home";
            }
        }

        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @RequestMapping(value = {"/main_user"})

        public String showUserPage(Model model) {
            return "user/main_user";
        }

        @Autowired
        private BanderyDAO dao;

        @RequestMapping("/index_bandera")
        public String viewHomePage(Model model) {
            /* Import java.util.List */
            List<Bandera> listBandera = dao.list();
            model.addAttribute("listBandera", listBandera);
            return "index_bandera";
        }

        @RequestMapping("/new")
        public String showNewForm(Model model) {
            Bandera bandera = new Bandera();
            model.addAttribute("bandera", bandera);
            return "new_form";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("bandera") Bandera bandera) {
            dao.save(bandera);
            return "redirect:/index_bandera";
        }

        @RequestMapping("/edit/{ID_bandery}")
        public ModelAndView showEditForm(@PathVariable(name = "ID_bandery") int ID_bandery) {
            ModelAndView mav = new ModelAndView("edit_form");
            Bandera bandera = dao.get(ID_bandery);
            mav.addObject("bandera", bandera);
            return mav;
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String update(@ModelAttribute("bandera") Bandera bandera) {
            dao.update(bandera);
            return "redirect:/index_bandera";
        }

        @RequestMapping("/delete/{ID_bandery}")
        public String delete(@PathVariable(name = "ID_bandery") int ID_bandery) {
            dao.delete(ID_bandery);
            return "redirect:/index_bandera";
        }


        @Autowired
        private AdresyDAO daoa;

        @RequestMapping("/index_adres")
        public String viewPageA(Model model) {
            /* Import java.util.List */
            List<Adres> listAdres = daoa.list();
            model.addAttribute("listAdres", listAdres);
            return "index_adres";
        }
        @RequestMapping("/newA")
        public String showFormA(Model model) {
            Adres adres = new Adres();
            model.addAttribute("adres", adres);
            return "new_formadres";
        }

        @RequestMapping(value = "/saveA", method = RequestMethod.POST)
        public String saveA(@ModelAttribute("adres") Adres adres) {
            daoa.save(adres);
            return "redirect:/index_adres";
        }

        @RequestMapping("/editA/{ID_adresu}")
        public ModelAndView showeditFormA(@PathVariable(name = "ID_adresu") int ID_adresu) {
            ModelAndView mav1 = new ModelAndView("edit_formadres");
            Adres adres = daoa.get(ID_adresu);
            mav1.addObject("adres", adres);
            return mav1;
        }

        @RequestMapping(value = "/updateA", method = RequestMethod.POST)
        public String updateA(@ModelAttribute("adres") Adres adres) {
            daoa.update(adres);
            return "redirect:/index_adres";
        }

        @RequestMapping("/deleteA/{ID_adresu}")
        public String deleteA(@PathVariable(name = "ID_adresu") int ID_adresu) {
            daoa.delete(ID_adresu);
            return "redirect:/index_adres";
        }

        @Autowired
        private WlascicieleDAO daow;

        @RequestMapping("/index_wlasciciel")
        public String viewPageW(Model model) {
            /* Import java.util.List */
            List<Wlasciciel> listWlasciciel = daow.list();
            model.addAttribute("listWlasciciel", listWlasciciel);

            return "index_wlasciciel";
        }

        @RequestMapping("/newWW")
        public String showFormW(Model model) {
            Wlasciciel wlasciciel = new Wlasciciel();
            model.addAttribute("wlasciciel", wlasciciel);
            return "new_formwlasciciel";
        }

        @RequestMapping(value = "/saveW", method = RequestMethod.POST)
        public String save(@ModelAttribute("wlasciciel") Wlasciciel wlasciciel) {
            daow.save(wlasciciel);
            return "redirect:/index_wlasciciel";
        }

        @RequestMapping("/editW/{ID_wlasciciela}")
        public ModelAndView showFormW(@PathVariable(name = "ID_wlasciciela") int ID_wlasciciela) {
            ModelAndView mav0 = new ModelAndView("edit_formwlasciciel");
            Wlasciciel wlasciciel = daow.get(ID_wlasciciela);
            mav0.addObject("wlasciciel", wlasciciel);
            return mav0;
        }

        @RequestMapping(value = "/updateW", method = RequestMethod.POST)
        public String updateW(@ModelAttribute("wlasciciel") Wlasciciel wlasciciel) {
            daow.update(wlasciciel);
            return "redirect:/index_wlasciciel";
        }

        @RequestMapping("/deleteW/{ID_wlasciciela}")
        public String deleteW(@PathVariable(name = "ID_wlasciciela") int ID_wlasciciela) {
            daow.delete(ID_wlasciciela);
            return "redirect:/index_wlasciciel";
        }

        @Autowired
        private PracownicyDAO daop;

        @RequestMapping("/index_pracownik")
        public String viewPageP(Model model) {
            /* Import java.util.List */
            List<Pracownik> listPracownik = daop.list();
            model.addAttribute("listPracownik", listPracownik);
            return "index_pracownik";
        }
        @RequestMapping("/newP")
        public String showFormP(Model model) {
            Pracownik pracownik = new Pracownik();
            model.addAttribute("pracownik", pracownik);
            return "new_formpracownik";
        }

        @RequestMapping(value = "/saveP", method = RequestMethod.POST)
        public String saveP(@ModelAttribute("pracownik") Pracownik pracownik) {
            daop.save(pracownik);
            return "redirect:/index_pracownik";
        }

        @RequestMapping("/editP/{ID_pracownika}")
        public ModelAndView showeditFormP(@PathVariable(name = "ID_pracownika") int ID_pracownika) {
            ModelAndView mav13 = new ModelAndView("edit_formpracownik");
            Pracownik pracownik = daop.get(ID_pracownika);
            mav13.addObject("pracownik", pracownik);
            return mav13;
        }

        @RequestMapping(value = "/updateP", method = RequestMethod.POST)
        public String updateP(@ModelAttribute("pracownik") Pracownik pracownik) {
            daop.update(pracownik);
            return "redirect:/index_pracownik";
        }

        @RequestMapping("/deleteP/{ID_pracownika}")
        public String deleteP(@PathVariable(name = "ID_pracownika") int ID_pracownika) {
            daop.delete(ID_pracownika);
            return "redirect:/index_pracownik";
        }

        @Autowired
        private KlienciDAO daok;

        @RequestMapping("/index_klient")
        public String viewPageK(Model model) {
            /* Import java.util.List */
            List<Klient> listKlient = daok.list();
            model.addAttribute("listKlient", listKlient);
            return "index_klient";
        }
        @RequestMapping("/newK")
        public String showFormK(Model model) {
            Klient klient = new Klient();
            model.addAttribute("klient", klient);
            return "new_formklient";
        }

        @RequestMapping(value = "/saveK", method = RequestMethod.POST)
        public String saveK(@ModelAttribute("klient") Klient klient) {
            daok.save(klient);
            return "redirect:/index_klient";
        }

        @RequestMapping("/editK/{ID_klienta}")
        public ModelAndView showeditFormK(@PathVariable(name = "ID_klienta") int ID_klienta) {
            ModelAndView mav6 = new ModelAndView("edit_formklient");
            Klient klient = daok.get(ID_klienta);
            mav6.addObject("klient", klient);
            return mav6;
        }

        @RequestMapping(value = "/updateK", method = RequestMethod.POST)
        public String updateK(@ModelAttribute("klient") Klient klient) {
            daok.update(klient);
            return "redirect:/index_klient";
        }

        @RequestMapping("/deleteK/{ID_klienta}")
        public String deleteK(@PathVariable(name = "ID_klienta") int ID_klienta) {
            daok.delete(ID_klienta);
            return "redirect:/index_klient";
        }
        @Autowired
        private UslugiDAO daou;

        @RequestMapping("/index_usluga")
        public String viewPageU(Model model) {
            /* Import java.util.List */
            List<Usluga> listUsluga = daou.list();
            model.addAttribute("listUsluga", listUsluga);
            return "index_usluga";
        }
        @RequestMapping("/newU")
        public String showFormU(Model model) {
            Usluga usluga = new Usluga();
            model.addAttribute("usluga", usluga);
            return "new_formusluga";
        }

        @RequestMapping(value = "/saveU", method = RequestMethod.POST)
        public String saveU(@ModelAttribute("usluga") Usluga usluga) {
            daou.save(usluga);
            return "redirect:/index_usluga";
        }

        @RequestMapping("/editU/{ID_uslugi}")
        public ModelAndView showeditFormU(@PathVariable(name = "ID_uslugi") int ID_uslugi) {
            ModelAndView mav7 = new ModelAndView("edit_formusluga");
            Usluga usluga = daou.get(ID_uslugi);
            mav7.addObject("usluga", usluga);
            return mav7;
        }

        @RequestMapping(value = "/updateU", method = RequestMethod.POST)
        public String updateU(@ModelAttribute("usluga") Usluga usluga) {
            daou.update(usluga);
            return "redirect:/index_usluga";
        }

        @RequestMapping("/deleteU/{ID_usluga}")
        public String deleteU(@PathVariable(name = "ID_uslugi") int ID_uslugi) {
            daou.delete(ID_uslugi);
            return "redirect:/index_usluga";
        }

        @Autowired
        private PortyDAO daopp;

        @RequestMapping("/index_port")
        public String viewPagepp(Model model) {
            /* Import java.util.List */
            List<Port> listPort = daopp.list();
            model.addAttribute("listPort", listPort);
            return "index_port";
        }
        @RequestMapping("/newpp")
        public String showFormPP(Model model) {
            Port port = new Port();
            model.addAttribute("port", port);
            return "new_formport";
        }

        @RequestMapping(value = "/savepp", method = RequestMethod.POST)
        public String savepp(@ModelAttribute("port") Port port) {
            daopp.save(port);
            return "redirect:/index_port";
        }

        @RequestMapping("/editpp/{ID_portu}")
        public ModelAndView showeditFormpp(@PathVariable(name = "ID_portu") int ID_portu) {
            ModelAndView mav9 = new ModelAndView("edit_formport");
            Port port = daopp.get(ID_portu);
            mav9.addObject("port", port);
            return mav9;
        }

        @RequestMapping(value = "/updatepp", method = RequestMethod.POST)
        public String updatepp(@ModelAttribute("port") Port port) {
            daopp.update(port);
            return "redirect:/index_port";
        }

        @RequestMapping("/deletepp/{ID_portu}")
        public String deletepp(@PathVariable(name = "ID_portu") int ID_portu) {
            daopp.delete(ID_portu);
            return "redirect:/index_portu";
        }


        @Autowired
        private StatkiDAO daos;

        @RequestMapping("/index_statek")
        public String viewPageS(Model model) {
            /* Import java.util.List */
            List<Statek> listStatek = daos.list();
            model.addAttribute("listStatek", listStatek);
            return "index_statek";
        }
        @RequestMapping("/newS")
        public String showFormS(Model model) {
            Statek statek = new Statek();
            model.addAttribute("statek", statek);
            return "new_formstatek";
        }

        @RequestMapping(value = "/saveS", method = RequestMethod.POST)
        public String saveS(@ModelAttribute("statek") Statek statek) {
            daos.save(statek);
            return "redirect:/index_statek";
        }

        @RequestMapping("/editS/{ID_statku}")
        public ModelAndView showeditFormS(@PathVariable(name = "ID_statku") int ID_statku) {
            ModelAndView mav10 = new ModelAndView("edit_formstatek");
            Statek statek = daos.get(ID_statku);
            mav10.addObject("statek", statek);
            return mav10;
        }

        @RequestMapping(value = "/updateS", method = RequestMethod.POST)
        public String updateS(@ModelAttribute("statek") Statek statek) {
            daos.update(statek);
            return "redirect:/index_statek";
        }

        @RequestMapping("/deleteS/{ID_statku}")
        public String deleteS(@PathVariable(name = "ID_statku") int ID_statku) {
            daos.delete(ID_statku);
            return "redirect:/index_statek";
        }

        @Autowired
        private ArmatorzyDAO daoaa;

        @RequestMapping("/index_armator")
        public String viewPageAA(Model model) {
            /* Import java.util.List */
            List<Armator> listArmator = daoaa.list();
            model.addAttribute("listArmator", listArmator);
            return "index_armator";
        }
        @RequestMapping("/newaa")
        public String showFormAA(Model model) {
            Armator armator = new Armator();
            model.addAttribute("armator", armator);
            return "new_formarmator";
        }

        @RequestMapping(value = "/saveaa", method = RequestMethod.POST)
        public String saveAA(@ModelAttribute("armator") Armator armator) {
            daoaa.save(armator);
            return "redirect:/index_armator";
        }

        @RequestMapping("/editaa/{ID_armatora}")
        public ModelAndView showeditFormAA(@PathVariable(name = "ID_armatora") int ID_armatora) {
            ModelAndView mav12 = new ModelAndView("edit_formarmator");
            Armator armator = daoaa.get(ID_armatora);
            mav12.addObject("armator", armator);
            return mav12;
        }

        @RequestMapping(value = "/updateaa", method = RequestMethod.POST)
        public String updateAA(@ModelAttribute("armator") Armator armator) {
            daoaa.update(armator);
            return "redirect:/index_armator";
        }

        @RequestMapping("/deleteaa/{ID_armatora}")
        public String deleteAA(@PathVariable(name = "ID_armatora") int ID_armatora) {
            daoaa.delete(ID_armatora);
            return "redirect:/index_armatora";
        }
        @Autowired
        private StatkiDAO daoss;

        @RequestMapping("/index_statekuser")
        public String viewPageSS(Model model) {
            /* Import java.util.List */
            List<Statek> listStatek = daoss.list();
            model.addAttribute("listStatek", listStatek);
            return "index_statekuser";}

    }
}




using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class CardManage
    {

        public static List<Card> getAllCards()
        {
            return CardServiecs.getAllCards();
        }

        public static Card getCardById(int card_id)
        {
            return CardServiecs.getCardById(card_id);
        }

        public static int addCard(Card d)
        {
            return CardServiecs.addCard(d);
        }

        public static int updateCard(Card card)
        {
            return CardServiecs.updateCard(card);
        }

        public static int deleteCard(int id)
        {
            return CardServiecs.deleteCard(id);
        }
    }
}

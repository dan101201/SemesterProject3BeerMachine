const openModalButtons = document.querySelectorAll('[data-popup-target]')
const closeModalButtons = document.querySelectorAll('[data-close-button]')
const overlay = document.getElementById('overlay')

openModalButtons.forEach(button =>{
    button.addEventListener('click', () =>{
        const popup = document.querySelector(button.dataset.popupTarget)
        openPopup(popup)
    })
})

closeModalButtons.forEach(button =>{
    button.addEventListener('click', () =>{
        const popup = button.closest('.popup')
        closePopup(popup)
    })
})

function openPopup(popup){
    if(popup == null) return
    popup.classList.add('active')
    overlay.classList.add('active')
}

function closePopup(popup){
    if(popup == null) return
    popup.classList.remove('active')
    overlay.classList.remove('active')
}